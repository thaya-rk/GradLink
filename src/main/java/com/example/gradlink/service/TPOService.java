package com.example.gradlink.service;

import com.example.gradlink.entity.TPO;
import java.util.List;
import java.util.Optional;

public interface TPOService {
    TPO saveTPO(TPO tpo);
    TPO updateTPO(Long id, TPO tpo);
    Optional<TPO> getTPOById(Long id);
    List<TPO> getAllTPOs();
    void deleteTPO(Long id);
}
