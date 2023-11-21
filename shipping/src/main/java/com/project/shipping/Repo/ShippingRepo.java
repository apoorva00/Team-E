package com.project.shipping.Repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shipping.Entity.Shipping;
public interface ShippingRepo extends JpaRepository<Shipping, Integer>{

}
