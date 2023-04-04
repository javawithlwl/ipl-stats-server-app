package com.lwl.iplstats.domain;


import com.lwl.iplstats.util.SecurityContextUtil;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {
  @Column(name = "created_by", nullable = false, updatable = false)
  private UUID createBy;
  @Column(name = "modified_by", nullable = false, updatable = true)
  private UUID modifiedBy;
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime cratedAt;
  @Column(name = "modified_at", nullable = false, updatable = true)
  private LocalDateTime modifiedAt;

  @PrePersist
  public void onPersists() {
    this.createBy = SecurityContextUtil.getCurrentUserId();
    this.modifiedBy = SecurityContextUtil.getCurrentUserId();
    this.cratedAt = LocalDateTime.now(ZoneOffset.UTC);
    this.modifiedAt = LocalDateTime.now(ZoneOffset.UTC);
  }

  @PreUpdate
  public void onUpdate() {
    this.modifiedBy = SecurityContextUtil.getCurrentUserId();
    this.modifiedAt = LocalDateTime.now(ZoneOffset.UTC);
  }


}
