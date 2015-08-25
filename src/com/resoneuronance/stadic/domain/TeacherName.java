package com.resoneuronance.stadic.domain;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class TeacherName  {

	public TeacherName( String name, boolean selected) {
		super();
		this.name = name;
		this.selected = selected;
	}
	String name = null;
	boolean selected = false;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
