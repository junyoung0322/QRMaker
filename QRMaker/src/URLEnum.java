
public enum URLEnum {
	URL01("http://www.giants.jp/top.html", 200, 200, "QRCode01_giantz.png"),
	URL02("https://www.amazon.co.jp/dp/B01BHPEC9G", 200, 200, "QRCode02_amazon.png"),
	URL03("http://www.cosme.net/product/product_id/10023860/top", 200, 200, "QRCode03_cosme.png");
	
	private String sUrl = null;
	private int iWidth = 0;
	private int iHeight = 0;
	private String sFileName = null;
	
	URLEnum(String sUrl, int iWidth, int iHeight, String sFileName) {
		this.sUrl = sUrl;
		this.iWidth = iWidth;
		this.iHeight = iHeight;
		this.sFileName = sFileName;
	}

	public String getsUrl() {
		return sUrl;
	}
	public int getiWidth() {
		return iWidth;
	}
	public int getiHeight() {
		return iHeight;
	}
	public String getsFileName() {
		return sFileName;
	}
}
