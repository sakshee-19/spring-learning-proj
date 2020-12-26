package com.udacity.bootstrap.services;

        import graphql.ErrorType;
        import graphql.GraphQLError;
        import graphql.language.SourceLocation;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.ResponseStatus;

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Breed Not Found")
public class BreedNotFoundException extends RuntimeException implements GraphQLError {

    public BreedNotFoundException(){}

    public BreedNotFoundException(String message){ super(message);}

    private Map<String, Object> extensions = new HashMap<>();

    public BreedNotFoundException(String message, String breed){ super(message); extensions.put("invalidBreedsId", breed);}

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
}
