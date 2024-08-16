## Design Patterns

[SourceMaking: Design Patterns](https://sourcemaking.com/design_patterns)

**What are design patterns?**

Design patterns are general reusable solutions to common problems that occur during software development. They represent best practices for designing and structuring code to solve certain types of problems.

## Low Level Design Problem Statements

### 1. Design an ATM

#### Details:
- **Problem**: Handling different types of transactions (withdrawal, deposit, balance inquiry).
- **Pattern**: Chain of Responsibility.
- **Description**: Each handler in the chain processes a specific type of transaction.

#### UML Diagram:

```mermaid

classDiagram
    class ATM {
        - Handler firstHandler
        + setHandlers(Handler... handlers)
        + handleRequest(Transaction request)
    }

    class Handler {
        - Handler nextHandler
        + setNextHandler(Handler handler)
        + handle(Transaction request)
    }

    class WithdrawalHandler {
        + handle(Transaction request)
    }

    class DepositHandler {
        + handle(Transaction request)
    }

    class BalanceInquiryHandler {
        + handle(Transaction request)
    }

    class Transaction {
        <<abstract>>
        + type: String
        + amount: Double
    }

    ATM --> Handler : "firstHandler"
    Handler <|-- WithdrawalHandler
    Handler <|-- DepositHandler
    Handler <|-- BalanceInquiryHandler
    Transaction <-- WithdrawalHandler : uses
    Transaction <-- DepositHandler : uses
    Transaction <-- BalanceInquiryHandler : uses

```

## 2. Design an Elevator System

#### Details:

- **Problem:** Managing elevator states and notifying floors.
- **Pattern:** State, Singleton, Observer.
- **Description:** Elevator state management, single instance control, and floor notifications.

#### UML Diagram:

```mermaid

classDiagram
    class Elevator {
        - ElevatorState state
        + setState(ElevatorState state)
        + requestFloor(int floor)
        + move()
    }

    class ElevatorState {
        <<interface>>
        + handleRequest(Elevator context, int floor)
    }

    class MovingUpState {
        + handleRequest(Elevator context, int floor)
    }

    class MovingDownState {
        + handleRequest(Elevator context, int floor)
    }

    class IdleState {
        + handleRequest(Elevator context, int floor)
    }

    class Floor {
        + update()
    }

    class ElevatorControl {
        - Elevator elevator
        + getInstance()
        + addObserver(Floor floor)
        + removeObserver(Floor floor)
        + notifyObservers()
    }

    Elevator --> ElevatorState
    ElevatorState <|.. MovingUpState
    ElevatorState <|.. MovingDownState
    ElevatorState <|.. IdleState
    ElevatorControl --> Elevator
    ElevatorControl --> Floor : observes

```

## 3. Design a Vending Machine

#### Details:

- **Problem:** Managing different states of the vending machine.
- **Pattern:** State.
- **Description:** Handling different states like waiting for money, dispensing item, and returning change.

#### UML Diagram:

```mermaid

classDiagram
    class VendingMachine {
        - VendingMachineState state
        + setState(VendingMachineState state)
        + insertMoney()
        + dispenseItem()
        + returnChange()
    }

    class VendingMachineState {
        <<interface>>
        + insertMoney(VendingMachine context)
        + dispenseItem(VendingMachine context)
        + returnChange(VendingMachine context)
    }

    class WaitingForMoneyState {
        + insertMoney(VendingMachine context)
    }

    class DispensingItemState {
        + dispenseItem(VendingMachine context)
    }

    class ReturningChangeState {
        + returnChange(VendingMachine context)
    }

    VendingMachine --> VendingMachineState
    VendingMachineState <|.. WaitingForMoneyState
    VendingMachineState <|.. DispensingItemState
    VendingMachineState <|.. ReturningChangeState

```

## 4. Design a Parking Lot System

#### Details:

- **Problem:** Managing parking spaces with different strategies.
- **Pattern:** Strategy, Singleton, Factory Method.
- **Description:** Implementing different parking strategies and ensuring a single instance of the parking manager.

#### UML Diagram:

```mermaid

classDiagram
    class ParkingLot {
        - ParkingStrategy strategy
        + setStrategy(ParkingStrategy strategy)
        + parkCar(Car car)
    }

    class ParkingStrategy {
        <<interface>>
        + parkCar(Car car)
    }

    class NearestSpotStrategy {
        + parkCar(Car car)
    }

    class FarthestSpotStrategy {
        + parkCar(Car car)
    }

    class ParkingSpotFactory {
        + createParkingSpot(String type)
    }

    class ParkingManager {
        - static ParkingManager instance
        + getInstance()
    }

    class Car {
        + licensePlate: String
    }

    ParkingLot --> ParkingStrategy
    ParkingStrategy <|.. NearestSpotStrategy
    ParkingStrategy <|.. FarthestSpotStrategy
    ParkingManager --> ParkingLot
    ParkingSpotFactory --> ParkingLot
    ParkingLot --> Car : parks

```

## 5. Design a Library Management System

#### Details:

- **Problem:** Managing different media types and notifications.
- **Pattern:** Factory Method, Observer, Strategy.
- **Description:** Creating different media items and notifying users about availability.

#### UML Diagram:

```mermaid

classDiagram
    class Library {
        + addMedia(MediaItem item)
        + registerUser(User user)
        + notifyUsers()
    }

    class MediaItem {
        <<interface>>
        + getTitle(): String
    }

    class Book {
        + getTitle(): String
    }

    class DVD {
        + getTitle(): String
    }

    class MediaFactory {
        + createMedia(String type): MediaItem
    }

    class User {
        + update(MediaItem item)
    }

    Library --> MediaItem
    MediaItem <|.. Book
    MediaItem <|.. DVD
    MediaFactory --> MediaItem : creates
    Library --> User : notifies

```

## 6. Design a Restaurant Reservation System

#### Details:

- **Problem:** Managing reservations with different strategies.
- **Pattern:** Singleton, Strategy.
- **Description:** Implementing various reservation algorithms and ensuring a single instance of the reservation manager.

#### UML Diagram:


```mermaid

classDiagram
    class ReservationSystem {
        - ReservationStrategy strategy
        + setStrategy(ReservationStrategy strategy)
        + reserveTable(Customer customer, DateTime time)
    }

    class ReservationStrategy {
        <<interface>>
        + reserveTable(Customer customer, DateTime time)
    }

    class FirstComeFirstServeStrategy {
        + reserveTable(Customer customer, DateTime time)
    }

    class PriorityBasedStrategy {
        + reserveTable(Customer customer, DateTime time)
    }

    class ReservationManager {
        - static ReservationManager instance
        + getInstance()
    }

    class Customer {
        + name: String
    }

    ReservationSystem --> ReservationStrategy
    ReservationStrategy <|.. FirstComeFirstServeStrategy
    ReservationStrategy <|.. PriorityBasedStrategy
    ReservationManager --> ReservationSystem
    ReservationSystem --> Customer : reserves for

```

## 7. Design a File System

#### Details:

- **Problem:** Managing files and directories in a hierarchical structure.
- **Pattern:** Composite, Iterator.
- **Description:** Treating files and directories uniformly and iterating over files in a directory.

#### UML Diagram:

```mermaid

classDiagram
    class FileSystemComponent {
        <<interface>>
        + getName(): String
        + getSize(): int
    }

    class File {
        + getName(): String
        + getSize(): int
    }

    class Directory {
        + getName(): String
        + getSize(): int
        + add(FileSystemComponent component)
        + remove(FileSystemComponent component)
        + getChildren(): List~FileSystemComponent~
    }

    class DirectoryIterator {
        + hasNext(): boolean
        + next(): FileSystemComponent
    }

    FileSystemComponent <|.. File
    FileSystemComponent <|.. Directory
    Directory --> FileSystemComponent : contains
    DirectoryIterator --> Directory : iterates

```

## 8. Design a Notification System

#### Details:

- **Problem:** Notifying multiple subscribers of an event.
- **Pattern:** Observer, Factory Method.
- **Description:** Creating different types of notifications and notifying subscribers.

#### UML Diagram:

```mermaid

classDiagram
    class NotificationSystem {
        + addObserver(Observer observer)
        + removeObserver(Observer observer)
        + notifyObservers(Notification notification)
    }

    class Observer {
        <<interface>>
        + update(Notification notification)
    }

    class EmailObserver {
        + update(Notification notification)
    }

    class SMSObserver {
        + update(Notification notification)
    }

    class NotificationFactory {
        + createNotification(String type): Notification
    }

    class Notification {
        + message: String
    }

    NotificationSystem --> Observer : notifies
    Observer <|.. EmailObserver
    Observer <|.. SMSObserver
    NotificationFactory --> Notification : creates

```

## 9. Design a Chat Application

#### Details:

- **Problem:** Managing communication between multiple chat participants.
- **Pattern:** Mediator, Observer.
- **Description:** Using a mediator to handle communication and observers to update participants of new messages.

#### UML Diagram:

```mermaid

classDiagram
    class ChatRoom {
        + sendMessage(String message, User user)
        + addUser(User user)
        + notifyUsers(String message, User user)
    }

    class User {
        + name: String
        + receiveMessage(String message, User user)
        + sendMessage(String message)
    }

    class ChatMediator {
        <<interface>>
        + sendMessage(String message, User user)
    }

    class ConcreteChatMediator {
        + sendMessage(String message, User user)
    }

    ChatRoom --> User : manages
    ChatRoom --> ChatMediator : uses
    ChatMediator <|.. ConcreteChatMediator
    ConcreteChatMediator --> User : communicates with

```
## 10. Design an Online Shopping Cart

#### Details:

- **Problem:** Handling different discount strategies and implementing undo functionality.
- **Pattern:** Strategy, Command.
- **Description:** Using different discount strategies and implementing actions like adding/removing items.

#### UML Diagram:

```mermaid

classDiagram
    class ShoppingCart {
        - List~CartItem~ items
        - DiscountStrategy discountStrategy
        + addItem(CartItem item)
        + removeItem(CartItem item)
        + calculateTotal(): double
    }

    class CartItem {
        + product: String
        + price: double
    }

    class DiscountStrategy {
        <<interface>>
        + applyDiscount(double amount): double
    }

    class NoDiscountStrategy {
        + applyDiscount(double amount): double
    }

    class SeasonalDiscountStrategy {
        + applyDiscount(double amount): double
    }

    class Command {
        <<interface>>
        + execute()
        + undo()
    }

    class AddItemCommand {
        + execute()
        + undo()
    }

    class RemoveItemCommand {
        + execute()
        + undo()
    }

    ShoppingCart --> DiscountStrategy
    DiscountStrategy <|.. NoDiscountStrategy
    DiscountStrategy <|.. SeasonalDiscountStrategy
    ShoppingCart --> CartItem : contains
    Command <|.. AddItemCommand
    Command <|.. RemoveItemCommand
    ShoppingCart --> Command : uses

```

## 11. Design a Traffic Light System

#### Details:

- **Problem:** Managing the different states of traffic lights.
- **Pattern:** State.
- **Description:** Handling different states like red, green, and yellow.

#### UML Diagram:

```mermaid

classDiagram
    class TrafficLight {
        - TrafficLightState state
        + setState(TrafficLightState state)
        + change()
    }

    class TrafficLightState {
        <<interface>>
        + handle(TrafficLight context)
    }

    class RedLightState {
        + handle(TrafficLight context)
    }

    class GreenLightState {
        + handle(TrafficLight context)
    }

    class YellowLightState {
        + handle(TrafficLight context)
    }

    TrafficLight --> TrafficLightState
    TrafficLightState <|.. RedLightState
    TrafficLightState <|.. GreenLightState
    TrafficLightState <|.. YellowLightState

```

## 12. Design a Movie Ticket Booking System

#### Details:

- **Problem:** Managing bookings and different seating strategies.
- **Pattern:** Singleton, Strategy, Template Method.
- **Description:** Ensuring a single instance of the booking manager, using different seating strategies, and defining the steps to book a ticket.

#### UML Diagram:

```mermaid

classDiagram
    class BookingSystem {
        - SeatingStrategy seatingStrategy
        + setSeatingStrategy(SeatingStrategy strategy)
        + bookTicket(Customer customer, Movie movie)
    }

    class SeatingStrategy {
        <<interface>>
        + findSeat(Movie movie): Seat
    }

    class FirstAvailableStrategy {
        + findSeat(Movie movie): Seat
    }

    class BestAvailableStrategy {
        + findSeat(Movie movie): Seat
    }

    class BookingManager {
        - static BookingManager instance
        + getInstance()
    }

    class Customer {
        + name: String
    }

    class Movie {
        + title: String
    }

    class Seat {
        + number: int
    }

    BookingSystem --> SeatingStrategy
    SeatingStrategy <|.. FirstAvailableStrategy
    SeatingStrategy <|.. BestAvailableStrategy
    BookingManager --> BookingSystem
    BookingSystem --> Customer : books for
    BookingSystem --> Movie : books for
    BookingSystem --> Seat : finds

```

## 13. Design an Online Payment System

#### Details:

- **Problem:** Handling different payment methods and steps in the payment process.
- **Pattern:** Strategy, Factory Method, Chain of Responsibility.
- **Description:** Using different payment methods, creating different payment gateways, and handling payment steps.

#### UML Diagram:

```mermaid

classDiagram
    class PaymentSystem {
        - PaymentStrategy strategy
        + setStrategy(PaymentStrategy strategy)
        + processPayment(double amount)
    }

    class PaymentStrategy {
        <<interface>>
        + pay(double amount)
    }

    class CreditCardStrategy {
        + pay(double amount)
    }

    class PayPalStrategy {
        + pay(double amount)
    }

    class PaymentFactory {
        + createPaymentMethod(String type): PaymentStrategy
    }

    class PaymentHandler {
        - PaymentHandler nextHandler
        + setNextHandler(PaymentHandler handler)
        + handle(PaymentRequest request)
    }

    class AuthorizationHandler {
        + handle(PaymentRequest request)
    }

    class ValidationHandler {
        + handle(PaymentRequest request)
    }

    class PaymentRequest {
        + amount: double
    }

    PaymentSystem --> PaymentStrategy
    PaymentStrategy <|.. CreditCardStrategy
    PaymentStrategy <|.. PayPalStrategy
    PaymentFactory --> PaymentStrategy : creates
    PaymentHandler <|.. AuthorizationHandler
    PaymentHandler <|.. ValidationHandler
    PaymentHandler --> PaymentHandler : next
    PaymentHandler --> PaymentRequest : processes

```

## 14. Design a Social Media Platform

#### Details:

- **Problem:** Managing posts and updating followers.
- **Pattern:** Observer, Factory Method, Command.
- **Description:** Updating followers of new posts, creating different types of posts, and implementing actions like liking, sharing, and commenting.

#### UML Diagram:


```mermaid

classDiagram
    class SocialMediaPlatform {
        + addObserver(Observer observer)
        + removeObserver(Observer observer)
        + notifyObservers(Post post)
    }

    class Observer {
        <<interface>>
        + update(Post post)
    }

    class Follower {
        + update(Post post)
    }

    class PostFactory {
        + createPost(String type): Post
    }

    class Post {
        + content: String
    }

    class TextPost {
        + content: String
    }

    class ImagePost {
        + content: String
        + imageUrl: String
    }

    class Command {
        <<interface>>
        + execute()
    }

    class LikeCommand {
        + execute()
    }

    class ShareCommand {
        + execute()
    }

    class CommentCommand {
        + execute()
    }

    SocialMediaPlatform --> Observer : notifies
    Observer <|.. Follower
    PostFactory --> Post : creates
    Post <|.. TextPost
    Post <|.. ImagePost
    Command <|.. LikeCommand
    Command <|.. ShareCommand
    Command <|.. CommentCommand

```

## 15. Design a Hospital Management System

#### Details:

- **Problem:** Managing patients' states and notifying doctors and patients.
- **Pattern:** Observer, Factory Method, State.
- **Description:** Notifying doctors and patients of updates, creating different types of medical records, and managing patient states.

#### UML Diagram:

```mermaid

classDiagram
    class HospitalSystem {
        + addObserver(Observer observer)
        + removeObserver(Observer observer)
        + notifyObservers(Patient patient)
    }

    class Observer {
        <<interface>>
        + update(Patient patient)
    }

    class Doctor {
        + update(Patient patient)
    }

    class Patient {
        - PatientState state
        + setState(PatientState state)
        + updateState()
    }

    class PatientState {
        <<interface>>
        + handle(Patient context)
    }

    class AdmittedState {
        + handle(Patient context)
    }

    class UnderTreatmentState {
        + handle(Patient context)
    }

    class DischargedState {
        + handle(Patient context)
    }

    class MedicalRecordFactory {
        + createRecord(String type): MedicalRecord
    }

    class MedicalRecord {
        + details: String
    }

    HospitalSystem --> Observer : notifies
    Observer <|.. Doctor
    Patient --> PatientState
    PatientState <|.. AdmittedState
    PatientState <|.. UnderTreatmentState
    PatientState <|.. DischargedState
    MedicalRecordFactory --> MedicalRecord : creates

```





