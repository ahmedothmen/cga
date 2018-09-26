package tn.esprit.cga.presentation.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.cga.entity.Type;;;

@ManagedBean
@SessionScoped
public class Datas_typeVehicle {
	public Type[] getTypes(){
		return Type.values();
	}

}
