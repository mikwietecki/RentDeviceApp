package org.example.springdata.components.app;

import jakarta.transaction.Transactional;
import org.example.springdata.components.customer.Customer;
import org.example.springdata.components.customer.CustomerRepository;
import org.example.springdata.components.device.Device;
import org.example.springdata.components.device.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class RentController {

    private final Scanner scanner;
    private final DeviceRepository deviceRepository;
    private final CustomerRepository customerRepository;

    public RentController(Scanner scanner, DeviceRepository deviceRepository, CustomerRepository customerRepository) {
        this.scanner = scanner;
        this.deviceRepository = deviceRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void rentDeviceToCustomer() {
        try {
            rent();
        } catch (RentException e) {
            System.err.println(e.getMessage());
        }
    }

    private void rent() {
        System.out.println("Podaj pesel klienta:");
        String pesel = scanner.nextLine();
        System.out.println("Podaj ID urządzenia:");
        long deviceId = scanner.nextLong();
        Optional<Customer> customer = customerRepository.findByPesel(pesel);
        Optional<Device> device = deviceRepository.findById(deviceId);
        if (customer.isPresent())
            device.ifPresentOrElse(dev -> {
                if (dev.getQuantity() > dev.getCustomers().size())
                    dev.addCustomer(customer.get());
                else
                    throw new RentException("Brak wolnych urządzeń o wskazanym ID");
            }, () -> {
                throw new RentException("Brak urządzenia o wskazanym ID");
            });
        else {
            throw new RentException("Brak klienta o wskazanym ID");
        }
    }
}
