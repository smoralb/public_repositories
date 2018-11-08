package com.example.sergiomoral.iphonedroid.presentation.ui.details;

import com.example.sergiomoral.iphonedroid.domain.entities.Contributor;
import com.example.sergiomoral.iphonedroid.domain.entities.Fork;

import java.util.List;

public interface DetailsView {

    void setContributors(List<Contributor> response);

    void setForks(List<Fork> response);

    void hideLoading();

    void close();

    void setIssues(String response);
}
