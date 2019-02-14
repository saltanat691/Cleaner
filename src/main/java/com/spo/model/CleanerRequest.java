package com.spo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CleanerRequest {

    @NotNull
    @Size(min = 1, max = 100)
    private List<Integer> rooms = new ArrayList<>();
    @NotNull
    @Min(1)
    private Integer senior;
    @NotNull
    @Min(1)
    private Integer junior;
}
