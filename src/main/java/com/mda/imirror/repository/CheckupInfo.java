package com.mda.imirror.repository;

import java.time.LocalDateTime;

/**
 * Projection for {@link com.mda.imirror.domain.entity.Checkup}
 */
public interface CheckupInfo {
    LocalDateTime getCreatedAt();
}