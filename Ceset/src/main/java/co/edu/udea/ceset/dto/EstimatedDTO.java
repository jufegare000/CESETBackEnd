/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ceset.dto;

import java.util.Collection;

/**
 *
 * @author jufeg
 */
public class EstimatedDTO {
    
    private Integer idEstimated;
    private Double totalBudget;
    private Double improvised;
    private Double contributionsUdeA;
    private Double contributionsFaculty;
    private AcademicActivityDTO idAcad;
    private Collection<EstimatedByItemDTO> estimatedbyitemCollection;
    private Collection<EstiamtedByExpenditureDTO> estimatedbyExpenditure;

    public EstimatedDTO() {
    }

    public Integer getIdEstimated() {
        return idEstimated;
    }

    public void setIdEstimated(Integer idEstimated) {
        this.idEstimated = idEstimated;
    }

    public Double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(Double totalBudget) {
        this.totalBudget = totalBudget;
    }

    public Double getImprovised() {
        return improvised;
    }

    public void setImprovised(Double improvised) {
        this.improvised = improvised;
    }

    public Double getContributionsUdeA() {
        return contributionsUdeA;
    }

    public void setContributionsUdeA(Double contributionsUdeA) {
        this.contributionsUdeA = contributionsUdeA;
    }

    public Double getContributionsFaculty() {
        return contributionsFaculty;
    }

    public void setContributionsFaculty(Double contributionsFaculty) {
        this.contributionsFaculty = contributionsFaculty;
    }

    public AcademicActivityDTO getIdAcad() {
        return idAcad;
    }

    public void setIdAcad(AcademicActivityDTO idAcad) {
        this.idAcad = idAcad;
    }

    public Collection<EstimatedByItemDTO> getEstimatedbyitemCollection() {
        return estimatedbyitemCollection;
    }

    public void setEstimatedbyitemCollection(Collection<EstimatedByItemDTO> estimatedbyitemCollection) {
        this.estimatedbyitemCollection = estimatedbyitemCollection;
    }

    public Collection<EstiamtedByExpenditureDTO> getEstimatedbyExpenditure() {
        return estimatedbyExpenditure;
    }

    public void setEstimatedbyExpenditure(Collection<EstiamtedByExpenditureDTO> estimatedbyExpenditure) {
        this.estimatedbyExpenditure = estimatedbyExpenditure;
    }
}