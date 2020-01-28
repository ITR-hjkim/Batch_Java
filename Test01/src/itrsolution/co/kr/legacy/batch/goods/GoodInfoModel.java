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
	 * 상품코드
	 * @return
	 */
	public String getGoodId() {
		return goodId;
	}
	/**
	 * 상품코드
	 * @param goodId
	 */
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	
	/**
	 * 상품명
	 * @return
	 */
	public String getGoodName() {
		return goodName;
	}
	/**
	 * 상품명
	 * @param goodName
	 */
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	
	/**
	 * 상태
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 상태
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 생성일시
	 * @return
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * 생성일시
	 * @param createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * 수정일시
	 * @return
	 */
	public String getModDate() {
		return modDate;
	}
	/**
	 * 수정일시
	 * @param modDate
	 */
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}	
}
