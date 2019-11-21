package by.gsu.ms42.idz12.exception;

public class TourNotFoundException extends RuntimeException {
    public TourNotFoundException() {
    }

    public TourNotFoundException(String message) {
        super(message);
    }
}
