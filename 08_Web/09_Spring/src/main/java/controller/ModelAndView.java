package controller;

public class ModelAndView {
	
	private String path;
	private boolean isRedirect;
	
	// path만 가지는 생성자
	public ModelAndView(String path) {
		this.path = path;
		this.isRedirect = false;
	}

	public ModelAndView() {
		super();
	}

	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
