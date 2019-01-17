package com.angualr.StatisticSaver.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_surname", nullable = false)
    private String userSurname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<UserPagesRelation> userPagesRelationsList;

    @Transient
    @JsonDeserialize
    @JsonSerialize
    private List<Pages> pagesList;

    @JsonIgnore
    public Set<UserPagesRelation> getUserPagesRelation(){
        return userPagesRelationsList;
    }

    public void setUserPagesRelation(Set<UserPagesRelation> userPagesRelation){
        this.userPagesRelationsList = userPagesRelation;
    }

    public List<Pages> getPagesList(){
        pagesList =new ArrayList<>();
        for (UserPagesRelation pagesRelation : getUserPagesRelation() ) {
            pagesList.add(pagesRelation.getPages());
        }
        return pagesList;
    }

    public void setPagesList(List<Pages> pagesList){
        userPagesRelationsList = new HashSet<>();
        for (Pages page: pagesList) {
            UserPagesRelation userPagesRelations = new UserPagesRelation();
            userPagesRelations.setPages(page);
            userPagesRelations.setUser(this);
            userPagesRelationsList.add(userPagesRelations);
        }
    }

}
