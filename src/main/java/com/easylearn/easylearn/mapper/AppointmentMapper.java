package com.easylearn.easylearn.mapper;

import com.easylearn.easylearn.entity.Appointment;
import com.easylearn.easylearn.model.AppointmentReqDTO;
import com.easylearn.easylearn.model.AppointmentRespDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
@Transactional
public class AppointmentMapper implements ObjectMapper<Appointment, AppointmentReqDTO, AppointmentRespDTO> {

    @Override
    public Appointment mapToEntity(AppointmentReqDTO request) {
        return null;
    }

    @Override
    public Appointment mapToEntity(Appointment entity, AppointmentReqDTO request) {
        return null;
    }

    @Override
    public AppointmentRespDTO mapToDTO(Appointment entity) {
        return null;
    }

    @Override
    public Set<AppointmentRespDTO> mapToDTOs(Set<Appointment> entities) {
        return null;
    }
    /*
    @Override
    public Exercise mapToEntity(ExerciseReqDTO request) {
        return Exercise.builder()
                .name(request.getName())
                .description(request.getDescription())
                .type(request.getType())
                .numberOfRounds(request.getNumberOfRounds())
                .duration(request.getDuration())
                .build();
    }

    @Override
    public Exercise mapToEntity(Exercise exercise, ExerciseReqDTO request) {
        exercise.setName(request.getName());
        exercise.setDescription(request.getDescription());
        exercise.setType(request.getType());
        exercise.setNumberOfRounds(request.getNumberOfRounds());
        exercise.setDuration(request.getDuration());
        return exercise;
    }

    @Override
    public ExerciseRespDTO mapToDTO(Exercise entity) {
        return ExerciseRespDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .type(entity.getType())
                .numberOfRounds(entity.getNumberOfRounds())
                .duration(entity.getDuration())
                .workoutId(entity.getWorkout().getId())
                .build();
    }

    @Override
    public Set<ExerciseRespDTO> mapToDTOs(Set<Exercise> entities) {
        if (entities == null || entities.isEmpty())
            return null;

        Set<ExerciseRespDTO> exercises = new HashSet<>();
        entities.forEach(exercise -> exercises.add(mapToDTO(exercise)));
        return exercises;
    }
     */
}
