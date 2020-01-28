package itrsolution.co.kr.legacy.batch.goods;

public class GoodInfoModel {
	
	private String goodId;
	private String goodName;
	private String status;
	private String createDate;
	private String modDate;
	
	public GoodInfoModel(String goodId, String goodName) {
		this.goodId = goodId;
		this.goodName = goodName;
	}
	
	/**
	 * ��ǰ�ڵ�
	 * @return
	 */
	public String getGoodId() {
		return goodId;
	}
	/**
	 * ��ǰ�ڵ�
	 * @param goodId
	 */
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	
	/**
	 * ��ǰ��
	 * @return
	 */
	public String getGoodName() {
		return goodName;
	}
	/**
	 * ��ǰ��
	 * @param goodName
	 */
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	
	/**
	 * ����
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * ����
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * �����Ͻ�
	 * @return
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * �����Ͻ�
	 * @param createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * �����Ͻ�
	 * @return
	 */
	public String getModDate() {
		return modDate;
	}
	/**
	 * �����Ͻ�
	 * @param modDate
	 */
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}	
}
