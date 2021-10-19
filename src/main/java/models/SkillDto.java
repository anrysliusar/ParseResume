package models;

import jakarta.validation.constraints.NotBlank;

public record SkillDto(
        @NotBlank
        String name,
        String level
) { }
