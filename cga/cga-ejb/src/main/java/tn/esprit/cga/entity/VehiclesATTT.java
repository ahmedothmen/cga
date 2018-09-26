package tn.esprit.cga.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: VehiclesATTT
 *
 */
@Entity

public class VehiclesATTT implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
   
}
