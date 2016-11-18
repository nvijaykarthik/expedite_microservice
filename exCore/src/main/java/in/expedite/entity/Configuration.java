package in.expedite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author vijayakarthik
 * DB entity class for configuration key vakue pair
 */
@Entity
@Table(name="CONFIGURATION")
public class Configuration {
	
	private Integer id;
	
	@NotBlank(message="Key is required")
	@Pattern(regexp="^[a-zA-Z0-9_]*$",message="In Valid Request")
	private String key;
	
	private String value;
	/**
	 * get ID
	 * @return
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	/**
	 * set id
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * get key
	 * @return
	 */
	@Column(name="KEY",unique=true,nullable=false)
	public String getKey() {
		return key;
	}
	/**
	 * get key
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * get value
	 * @return
	 */
	@Column(name="VALUE",nullable=true)
	public String getValue() {
		return value;
	}
	
	/** 
	 * set value
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Configuration [id=" + id + ", key=" + key + ", Value=" + value + "]";
	}

}
