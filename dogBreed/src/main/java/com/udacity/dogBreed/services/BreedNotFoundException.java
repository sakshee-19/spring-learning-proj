package com.udacity.dogBreed.services;


        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.ResponseStatus;

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Breed Not Found")
public class BreedNotFoundException extends RuntimeException {

    public BreedNotFoundException(){}

    public BreedNotFoundException(String message){ super(message);}
}
