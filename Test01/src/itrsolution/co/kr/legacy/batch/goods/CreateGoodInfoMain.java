package itrsolution.co.kr.legacy.batch.goods;

public class CreateGoodInfoMain {

	public static void main(String[] args) {
        int threadCnt = 1;
        
		try {
			if(args.length == 1) {
				try {
					threadCnt = Integer.parseInt(args[0]);
				} catch (Exception e) {
				}
			}
			
			System.out.println("Thread Count : " + threadCnt);
			
			long beforeTime = System.currentTimeMillis();
			GoodInfoManager mgr = new GoodInfoManager(threadCnt);
			mgr.Start();
			long afterTime = System.currentTimeMillis();
			System.out.println("ÃÑ ¼Ò¿ä½Ã°£ : " + (afterTime - beforeTime) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
