package com.connex.ctoml.Repositories;

import com.connex.ctoml.Entités.Dataset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Repodataset extends JpaRepository<Dataset,Long> {

}
