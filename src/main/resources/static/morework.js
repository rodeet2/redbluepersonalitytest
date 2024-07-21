document.addEventListener("DOMContentLoaded", function() {
  
    const modal = document.querySelector(".modal");
    const closeModalBtn = document.querySelector(".btn-close");
  
    // Close modal function
    const closeModal = function () {
      modal.classList.add("hidden");
    };
  
    // Close the modal when the close button is clicked
    closeModalBtn.addEventListener("click", closeModal);
  
    // Close modal when the Esc key is pressed
    document.addEventListener("keydown", function (e) {
      if (e.key === "Escape" && !modal.classList.contains("hidden")) {
        closeModal();
      }
    });
  
  });
  