package com.thaya.gradlink.repository;

import com.thaya.gradlink.entity.TPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TPORepository extends JpaRepository<TPO, Long> {


}
