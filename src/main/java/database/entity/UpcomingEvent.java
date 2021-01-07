package database.entity;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "UPCOMING_EVENT")
public class UpcomingEvent {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private int duration;
        private LocalDateTime traveltime;

        @ManyToOne
        @JoinColumn(name = "user_position_id")
        private UserLocation user_location;

        public UpcomingEvent() {
        }
}
