<script>
  let {
    record_title,
    doctor_name,
    visit_purpose,
    blood_pressure,
    body_temperature,
    heart_rate,
    visit_date,
    symptoms_felt,
    diagnosis,
    prescribed_medicine,
    medicine_intake_time,
    additional_notes,
    id
  } = $props();

  // const formattedVisitDate = new Date(visit_date).toISOString().split('T')[0];
</script>

<style>
  .card {
    border: 1px solid #ddd;
    margin: 10px;
    padding: 20px;
    width: 200px;
    background-color: #f9f9f9;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }

  .card h2 {
    font-size: 1.2rem;
    margin-bottom: 8px;
  }

  .card p {
    font-size: 1rem;
    color: #555;
  }
</style>

<div class="card">
  <h2>{record_title}</h2>
  <p>{doctor_name}</p>
  <p>{visit_purpose}</p>
  <p>{visit_date}</p>
</div>