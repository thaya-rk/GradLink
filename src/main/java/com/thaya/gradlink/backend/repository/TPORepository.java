package com.thaya.gradlink.backend.repository;

import com.thaya.gradlink.backend.entity.TPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TPORepository extends JpaRepository<TPO, Long> {


}
