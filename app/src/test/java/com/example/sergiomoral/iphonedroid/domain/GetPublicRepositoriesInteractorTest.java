package com.example.sergiomoral.iphonedroid.domain;

import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;
import com.example.sergiomoral.iphonedroid.domain.interactor.GetPublicRepositoriesInteractor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GetPublicRepositoriesInteractorTest {

    @Mock
    List<PublicRepositories> publicRepositories;

    @Mock
    GetPublicRepositoriesInteractor.Callback<List<PublicRepositories>> callback;

    @Mock
    GetPublicRepositoriesInteractor interactor;

    @Mock
    Exception exception;

    @Test
    public void shouldGetContributorsSuccess() {

        interactor.execute(callback);
        callback.onSuccess(publicRepositories);


        verify(callback).onSuccess(publicRepositories);
        verify(interactor).execute(callback);
    }

    @Test
    public void shouldThrowException() {

        interactor.execute(callback);
        callback.onError(exception);

        verify(callback).onError(exception);
        verify(interactor).execute(callback);
    }
}
