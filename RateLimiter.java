package class_diagram;

/**
 * Tells AudioUpload how many files the current user uploaded in the last hour.
 * In the real app this would query the database; in tests it is replaced by a stub.
 */
public interface RateLimiter {
	int countUploadsInLastHour();
}
