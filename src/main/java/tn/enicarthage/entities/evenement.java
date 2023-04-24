package tn.enicarthage.entities;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
	import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
	import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
	import lombok.ToString;
	import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
	@FieldDefaults(level = AccessLevel.PRIVATE)
	@Getter
	@Setter
	@Builder
	@ToString
	@EqualsAndHashCode
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Table(name = "evenement")
	@JsonInclude(JsonInclude.Include.ALWAYS)
public class evenement implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(name = "nom")
		private String nom;
		
		@Column(name = "date")
		private Date date;

		@Column(name = "lieu")
		private String lieu;

		@Column(name = "description")
		private String description;

		@Column(name = "capacite")
		private int capacite;

		@Column(name = "organisateur")
		private String organisateur;
		
		
		//les associations:

		@ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "evenement_categorie", joinColumns = @JoinColumn(name = "evenement_id"), inverseJoinColumns = @JoinColumn(name = "categorie_id"))
	    List<categorie> categoriesList = null;
	    
	    
	    @OneToMany(mappedBy = "event")
	    @JsonBackReference
	    @EqualsAndHashCode.Exclude // <<<<<<<<<<
	    @ToString.Exclude
	    private Set<userForm> userForms  = new HashSet<>();


	

	    

}
