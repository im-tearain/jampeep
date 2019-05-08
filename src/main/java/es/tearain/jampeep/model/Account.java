package es.tearain.jampeep.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACC")
public class Account implements Serializable {

	@Id
	@Column(name = "ACC_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ACC_SER")
	private Service serviceName;

	@Column(name = "ACC_NAM")
	private String name;

	@Column(name = "ACC_PAS")
	private String password;

	@Column(name = "ACC_DAT")
	private Date creationDate;

	private Account() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Service getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(Service serviceName) {
		this.serviceName = serviceName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final Account other = (Account) obj;
		if (this.id != other.id)
			return false;
		return true;
	}

}
