package com.Accountancy.Accountancy.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountanctRepository extends JpaRepository<Patient,Long> {
}
