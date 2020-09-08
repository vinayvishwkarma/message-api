package com.fsecure.messageapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsecure.messageapi.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
	
	/*@Query(value = "Select title , content, sender from Message" , nativeQuery = true)
	public List<Object[]> findAllMessage();*/
	

}
