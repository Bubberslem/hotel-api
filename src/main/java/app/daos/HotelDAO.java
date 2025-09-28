package app.daos;

import app.dtos.HotelDTO;
import app.dtos.RoomDTO;
import app.entities.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class HotelDAO implements IDAO {

    private static HotelDTO instance;
    private static EntityManagerFactory emf;

    private HotelDAO() {
        // private constructor
    }

    public static HotelDTO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            instance = new HotelDTO();
            emf = _emf;
        }
        return instance;
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        List<HotelDTO> hotelList = new ArrayList<>();
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Hotel> query = em.createQuery("SELECT h FROM Hotel h", Hotel.class);
            return HotelDTO.toDTOList(query.getResultList());
        }
    }

    @Override
    public HotelDTO create(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel(hotelDTO);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(hotel);
            em.getTransaction().commit();
        }
        return new HotelDTO(hotel);
    }

    public List<HotelDTO> createFromList(HotelDTO[] hotelDTOS) {
        List<HotelDTO> hotelDTOList = new ArrayList<>();
        for (int index = 0; index < hotelDTOS.length; index++) {
            HotelDTO newHotelDTO = create(hotelDTOS[index]);
            hotelDTOList.add(newHotelDTO);
        }
        return hotelDTOList;
    }

    public HotelDTO getHotelById(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            Hotel hotel = em.find(Hotel.class, id);
            if (hotel != null) {
                return new HotelDTO(hotel);
            }
            return null;
        }
    }

    public void deleteHotel(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Hotel hotel = em.find(Hotel.class, id);
            if (hotel != null) {
                em.remove(hotel);
            }
            em.getTransaction().commit();
        }
    }

    public HotelDTO updateHotel(int id, HotelDTO hotelDTO) {
        try (EntityManager em = emf.createEntityManager()) {
            Hotel hotel = em.find(Hotel.class, id);
            if (hotel != null) {
                em.getTransaction().begin();
                hotel.setName(hotelDTO.getName());
                hotel.setAddress(hotelDTO.getAddress());
                hotel.setRooms(hotelDTO.getRooms());
                hotel.setStars(hotelDTO.getStars());
                em.getTransaction().commit();
            }
            ;
            return new HotelDTO(hotel);
        }
    }

    public HotelDTO addRoom(int hotelId, RoomDTO roomDto) {
        return null;
    }

    public HotelDTO removeRoom(int hotelId, int roomId) {
        return null;
    }

    public List<RoomDTO> getRoomsForHotel(int hotelId) {
        return null;
    }
    
}
