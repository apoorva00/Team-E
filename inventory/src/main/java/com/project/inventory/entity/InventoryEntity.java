package com.project.inventory.entity;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table (name="Inventory")


public class InventoryEntity {
	

		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)

		int inventory_id;
		LocalDate start_date;
		LocalDate end_date;
		@Override
		public String toString() {
			return "Inventory [inventory_id=" + inventory_id + ", start_date=" + start_date + ", end_date=" + end_date
					+ "]";
		}
		public int getInventory_id() {
			return inventory_id;
		}
		public void setInventory_id(int inventory_id) {
			this.inventory_id = inventory_id;
		}
		public LocalDate getStart_date() {
			return start_date;
		}
		public void setStart_date(LocalDate start_date) {
			this.start_date = start_date;
		}
		public LocalDate getEnd_date() {
			return end_date;
		}
		public void setEnd_date(LocalDate end_date) {
			this.end_date = end_date;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(end_date, inventory_id, start_date);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			InventoryEntity other = (InventoryEntity) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(end_date, other.end_date) && inventory_id == other.inventory_id
					&& Objects.equals(start_date, other.start_date);
		}
		private InventoryEntity getEnclosingInstance() {
			return InventoryEntity.this;
		}
		public InventoryEntity(int inventory_id, LocalDate string, LocalDate string2) {
			super();
			this.inventory_id = inventory_id;
			this.start_date = string;
			this.end_date = string2;
		}
		public InventoryEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	}
	