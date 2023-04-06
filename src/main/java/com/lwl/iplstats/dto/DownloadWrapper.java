package com.lwl.iplstats.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class DownloadWrapper {
    List<TeamDto> Team =new ArrayList<>();
}
