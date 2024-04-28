package com.utkarshhardwareandplywood.springboot.website.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utkarshhardwareandplywood.springboot.website.models.ShippingDetails;

public interface RepoShippingDetails extends JpaRepository<ShippingDetails, Integer> {

}
