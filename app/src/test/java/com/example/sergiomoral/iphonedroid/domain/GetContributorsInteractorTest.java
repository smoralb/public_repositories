package com.example.sergiomoral.iphonedroid.domain;

import com.example.sergiomoral.iphonedroid.domain.entities.Contributor;
import com.example.sergiomoral.iphonedroid.domain.executor.InteractorExecutor;
import com.example.sergiomoral.iphonedroid.domain.executor.MainThreadExecutor;
import com.example.sergiomoral.iphonedroid.domain.interactor.GetContributorsInteractor;
import com.example.sergiomoral.iphonedroid.domain.interactor.GetIssuesInteractor;
import com.example.sergiomoral.iphonedroid.domain.interactor.GetPublicRepositoriesInteractor;
import com.example.sergiomoral.iphonedroid.domain.mock.InteractorExecutorMock;
import com.example.sergiomoral.iphonedroid.domain.mock.MainThreadExecutorMock;
import com.example.sergiomoral.iphonedroid.domain.repository.Repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class GetContributorsInteractorTest {

    @Mock
    List<Contributor> contributor;

    @Mock
    Repository repository;

    @Mock
    GetContributorsInteractor.Callback<List<Contributor>> callback;

    @Mock
    GetContributorsInteractor interactor;

    @Mock
    Exception exception;

    @Test
    public void shouldGetContributorsSuccess() {

        interactor.execute("octocat", "Hello_World", callback);
        callback.onSuccess(contributor);

        verify(interactor).execute("octocat", "Hello_World", callback);
        verify(callback).onSuccess(contributor);
    }

    @Test
    public void shouldThrowException() {

        interactor.execute("octocat", "Hello_World", callback);
        callback.onError(exception);

        verify(interactor).execute("octocat", "Hello_World", callback);
        verify(callback).onError(any(Exception.class));
    }
}
