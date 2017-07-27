package pl.training.backend.reservation.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import pl.training.backend.reservation.dto.ReservationDto;

import java.util.List;

@ApiModel(value = "Reservations")
@Data
public class ReservationPageDto {

    private List<ReservationDto> reservations;
    private int pageNumber;
    private int totalPages;

    public ReservationPageDto() {
    }

    public ReservationPageDto(List<ReservationDto> reservations, int pageNumber, int totalPages) {
        this.reservations = reservations;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }

}