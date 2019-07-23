package com.lhy.fool.admin.person.controller.supplier;

import java.util.List;

public class SendCopDataModel {
	
	/**
	 * 网点
	 */
	private List<Point> points ;

	/**
	 * 分机
	 */
	private List<Extension> extensions;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public List<Extension> getExtensions() {
		return extensions;
	}

	public void setExtensions(List<Extension> extensions) {
		this.extensions = extensions;
	}

	@Override
	public String toString() {
		return "SendCopDataModel [points=" + points + ", extensions="
				+ extensions + "]";
	}


	
	

}
