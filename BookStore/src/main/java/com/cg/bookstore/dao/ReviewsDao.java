package com.cg.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.bookstore.entity.Reviews;

/*******************************************************************************************************************************
 * -Author : Chandrika -Created/Modified Date : 00-09-2020 -Description :
 * ReviewsDao Interface with Reviews as Type and String as Key
 *******************************************************************************************************************************/

@Repository
public interface ReviewsDao extends JpaRepository<Reviews, String> {
}
