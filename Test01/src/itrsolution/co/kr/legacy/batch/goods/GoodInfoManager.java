package itrsolution.co.kr.legacy.batch.goods;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import itrsolution.co.kr.legacy.batch.commons.DBConnection;

public class GoodInfoManager {

	private final int threadCnt;
	private final int DATA_COUNT = 5000;

	private Boolean isFinished = false;
	private GoodInfoProc goodInfo = null;
	private Queue<GoodInfoModel> queue = new LinkedList<GoodInfoModel>();

	public GoodInfoManager(int threadCnt) {
		this.goodInfo = new GoodInfoProc();
		this.threadCnt = threadCnt;
	}
	
	private synchronized GoodInfoModel getData() {
		System.out.println("queue size : " + this.queue.size());
		return queue.poll();
	}
	
	public void Start() {
		ArrayList<Thread> threadList = new ArrayList<Thread>();
		System.out.println("Data count : " + DATA_COUNT);

		// Thread 처리할 작업 정의
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				Connection conn = DBConnection.getConnMainDB();

				while (true) {
//					String thName = Thread.currentThread().getName();
					if (queue.isEmpty()) {
//						System.out.println(thName + "queue empty");
						if (isFinished) {
//							System.out.println(thName + "terminated.");
							break;
						} else {
							try {
//								System.out.println(thName + "sleep");
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					} else {
						GoodInfoModel gi = getData();
						if (gi != null) {
//							System.out.println(thName + "poll : " + gi.getGoodId());
							goodInfo.insertGoodInfo(conn, gi.getGoodId(), gi.getGoodName());
						}
					}
				}
			}
		};
		
		// 작업 처리 Thread 생성
		for (int i = 0; i < this.threadCnt; i++) {
			Thread t = new Thread(r, "[thread-" + i + "]");
			threadList.add(t);
			t.start();
		}
		
		// 처리할 데이터 큐에 삽입
		Connection conn = DBConnection.getConnMainDB();
		try {
			int startNo = goodInfo.getLastNo(conn);
			for (int i = startNo; i < startNo+DATA_COUNT; i++) {
				String goodId = String.format("%013d", i);
				queue.offer(new GoodInfoModel(goodId, goodId));
			}
			isFinished = true;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		// Thread 처리 완료될때 까지 대기
		for (int i = 0; i < this.threadCnt; i++) {
			try {
				threadList.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
