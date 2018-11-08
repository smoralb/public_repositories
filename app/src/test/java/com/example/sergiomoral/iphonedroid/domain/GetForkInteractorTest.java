package com.example.sergiomoral.iphonedroid.domain;


import com.example.sergiomoral.iphonedroid.domain.entities.Fork;
import com.example.sergiomoral.iphonedroid.domain.interactor.GetForksInteractor;
import com.example.sergiomoral.iphonedroid.domain.repository.Repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class GetForkInteractorTest {

    @Mock
    List<Fork> forks;

    @Mock
    Repository repository;

    @Mock
    GetForksInteractor.Callback<List<Fork>> callback;

    @Mock
    GetForksInteractor interactor;

    @Mock
    Exception exception;

    @Test
    public void shouldGetContributorsSuccess() {

        interactor.execute("octocat", "Hello_World", callback);
        callback.onSuccess(forks);

        verify(callback).onSuccess(forks);
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

