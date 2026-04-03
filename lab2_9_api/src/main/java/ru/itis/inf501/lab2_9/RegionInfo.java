package ru.itis.inf501.lab2_9;

import java.util.List;

public class RegionInfo {
    private Long id;
    private Integer type;
    private Integer capitalId;
    private List<Integer> hierarchy;
    private String seoname;
    private List<Double[]> bounds;
    private Double longitude;
    private Double latitude;
    private Integer zoom;
    private Names names;
    private RegionInfo parentRegion;
    private String title;
    private String subtitle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(Integer capitalId) {
        this.capitalId = capitalId;
    }

    public List<Integer> getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(List<Integer> hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getSeoname() {
        return seoname;
    }

    public void setSeoname(String seoname) {
        this.seoname = seoname;
    }

    public List<Double[]> getBounds() {
        return bounds;
    }

    public void setBounds(List<Double[]> bounds) {
        this.bounds = bounds;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getZoom() {
        return zoom;
    }

    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

    public Names getNames() {
        return names;
    }

    public void setNames(Names names) {
        this.names = names;
    }

    public RegionInfo getParentRegion() {
        return parentRegion;
    }

    public void setParentRegion(RegionInfo parentRegion) {
        this.parentRegion = parentRegion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
