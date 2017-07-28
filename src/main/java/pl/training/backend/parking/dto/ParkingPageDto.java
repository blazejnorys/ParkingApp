package pl.training.backend.parking.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import pl.training.backend.parking.dto.ParkingDto;
import pl.training.backend.reservation.dto.ReservationDto;

import java.util.List;

@ApiModel(value = "Parkings")
@Data
public class ParkingPageDto {

    private List<ParkingDto> parkings;
    private int pageNumber;
    private int totalPages;

    public ParkingPageDto() {
    }

    public ParkingPageDto(List<ParkingDto> parkings, int pageNumber, int totalPages) {
        this.parkings = parkings;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }

}