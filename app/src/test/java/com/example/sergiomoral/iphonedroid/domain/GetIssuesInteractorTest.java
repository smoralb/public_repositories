package com.example.sergiomoral.iphonedroid.domain;

import com.example.sergiomoral.iphonedroid.domain.entities.Issue;
import com.example.sergiomoral.iphonedroid.domain.interactor.GetIssuesInteractor;
import com.example.sergiomoral.iphonedroid.domain.repository.Repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GetIssuesInteractorTest {


    @Mock
    Issue issue;

    @Mock
    GetIssuesInteractor.Callback<Issue> callback;

    @Mock
    GetIssuesInteractor interactor;

    @Mock
    Exception exception;

    @Test
    public void shouldGetContributorsSuccess() {

        interactor.execute("octocat", "Hello_World", callback);
        callback.onSuccess(issue);

        verify(callback).onSuccess(issue);
        verify(interactor).execute("octocat", "Hello_World", callback);
    }

    @Test
    public void shouldThrowException() {

        interactor.execute("octocat", "Hello_World", callback);
        callback.onError(exception);

        verify(callback).onError(any(Exception.class));
        verify(interactor).execute("octocat", "Hello_World", callback);
    }

}
