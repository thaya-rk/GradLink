package com.thaya.gradlink.backend.service.impl;

import com.thaya.gradlink.backend.entity.TPO;
import com.thaya.gradlink.backend.repository.TPORepository;
import com.thaya.gradlink.backend.service.TPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TPOServiceImpl implements TPOService {

    private final TPORepository tpoRepository;

    @Autowired
    public TPOServiceImpl(TPORepository tpoRepository) {
        this.tpoRepository = tpoRepository;
    }

    @Override
    public TPO saveTPO(TPO tpo) {
        return tpoRepository.save(tpo);
    }

    @Override
    public TPO updateTPO(Long id, TPO tpo) {
        if (tpoRepository.existsById(id)) {
            tpo.setId(id);
            return tpoRepository.save(tpo);
        }
        return null;
    }

    @Override
    public Optional<TPO> getTPOById(Long id) {
        return tpoRepository.findById(id);
    }

    @Override
    public List<TPO> getAllTPOs() {
        return tpoRepository.findAll();
    }

    @Override
    public void deleteTPO(Long id) {
        if (tpoRepository.existsById(id)) {
            tpoRepository.deleteById(id);
        }
    }
}
