package com.pccw.reactiveweb.repository;

import com.pccw.reactiveweb.domain.Port;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PortMongoBlockingRepository extends MongoRepository<Port, String> {
}
