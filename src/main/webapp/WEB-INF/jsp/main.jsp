<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Hospital Managament System</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Krub:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  
  
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  
  <style type="text/css">
  <%@ include file="/WEB-INF/assets/css/style.css" %>
   <%@ include file="/WEB-INF/assets/vendor/bootstrap/css/bootstrap.min.css" %>
  <%@ include file="/WEB-INF/assets/vendor/bootstrap-icons/bootstrap-icons.css" %>
  <%@ include file="/WEB-INF/assets/vendor/boxicons/css/boxicons.min.css" %> 
 <%@ include file= "/WEB-INF/assets/vendor/glightbox/css/glightbox.min.css" %>
 <%@ include file= "/WEB-INF/assets/vendor/swiper/swiper-bundle.min.css" %>
  </style>

  <!-- =======================================================
  * Template Name: Hospital Management System - v4.3.0
  * Template URL: https://bootstrapmade.com/Hospital Management System-free-simple-landing-page-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center justify-content-between">

      <!--<h1 class="logo"><a href="index.html">Hospital Management System</a></h1>-->
      <!-- Uncomment below if you prefer to use an image logo -->
       <a href="index.html" class="logo"><img src="https://firebasestorage.googleapis.com/v0/b/indigo-listener-256706.appspot.com/o/hmsmngmnt_bg.png?alt=media&token=76bdbc8f-f3cb-437d-a2d2-a7d12e499ee2" style="width:150px;height:240px; class="img-fluid"></a>

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto active" href="#hero">Home</a></li>
          <li><a class="nav-link scrollto" href="#about">About</a></li>
          <li><a class="nav-link scrollto" href="#services">Services</a></li>
	<li><a  href="http://localhost:8080/login">Login</a></li>
          <li class="dropdown"><a href="#"><span>Sign Up</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="http://localhost:8080/register_patient">Patient</a></li>
              <li><a href="http://localhost:8080/register_doctor">Doctor</a></li>
              <li><a href="http://localhost:8080/register_hospital_admin">Hospital Admin</a></li>
              
            </ul>
          </li>
          <li><a class="nav-link scrollto" href="#contact">Contact Us</a></li>
          <li><a class="getstarted scrollto" href="#about">Get Started</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex align-items-center">

    <div class="container d-flex flex-column align-items-center justify-content-center" data-aos="fade-up">
      <h1><span style="color:#eec0c6">H</span>ospital <span style="color:#0080FF">M</span>anagement <span style="color:#3cb371">S</span>ystem</h1><br>
      <h4>Hospital Management is a term very broad in scope and may be defined from different aspects. It mainly relates to management of all aspects of a hospital.</h4>
      <a href="#about" class="btn-get-started scrollto">Get Started</a><br>
    <img src="https://firebasestorage.googleapis.com/v0/b/indigo-listener-256706.appspot.com/o/hospital.jpg?alt=media&token=51933a38-2307-46ed-bc4e-d1a239e16eee"  alt="" data-aos="zoom-in" style="width:800px;height:400px; data-aos-delay="150">
    </div>

  </section><!-- End Hero -->

  <main id="main">

    <!-- ======= About Section ======= -->
    <section id="about" class="about">
      <div class="container">

        <div class="row no-gutters">
          <div class="content col-xl-5 d-flex align-items-stretch" data-aos="fade-right">
            <div class="content">
              <h3>HealthVibe Care & Services</h3>
              <p>
Hospital Management System
Covering all aspects of the hospital environment, hospitalmanagement.net provides both clinical and senior administrative staff with instant access to a comprehensive reference source introducing technologies, services and procedures our audience can employ to improve the management of their facilities.
               </p>
              <a href="#" class="about-btn">About us <i class="bx bx-chevron-right"></i></a>
            </div>
          </div>
          <div class="col-xl-7 d-flex align-items-stretch" data-aos="fade-left">
            <div class="icon-boxes d-flex flex-column justify-content-center">
              <div class="row">
                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="100">
                  <i class="bx bx-receipt"></i>
                  <h4>A FULLY-ACCREDITED, MODERN FACILITY.</h4>
                  <p>Our accomplished hospital has received numerous accreditations, designations and awards for trusted, top-tier healthcare.</p>
                </div>
                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="200">
                  <i class="bx bx-cube-alt"></i>
                  <h4>DISTINGUISHED MEDICAL TALENT.</h4>
                  <p>Our industry reputation is built upon the high-caliber medical professionals who offer insights, provide peace of mind, and save lives every day. </p>
                </div>
                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="300">
                  <i class="bx bx-images"></i>
                  <h4>COMMUNITY-MINDED INITIATIVES.</h4>
                  <p>At HealthVibe General Hospital, we believe we hold a community responsibility that extends beyond our facility walls. That is why, every year, we make public education, neighborhood health screenings, programs for the underserved, and other community initiatives a priority.</p>
                </div>
                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="400">
                  <i class="bx bx-shield"></i>
                  <h4>INNOVATIVE CARE FROM PASSIONATE PROFESSIONALS.</h4>
                  <p>Our patient care staff seeks out the latest treatments and techniques. Twice, Humboldt General Hospital has been named a "Top 10 Innovator" for its innovative pre-hospital and hospital care.</p>
                </div>
              </div>
            </div><!-- End .content-->
          </div>
        </div>

      </div>
    </section><!-- End About Section -->

   
    <!-- ======= Features Section ======= -->
    <section id="features" class="features" data-aos="fade-up">
      <div class="container">

        <div class="section-title">
          <h2>Features</h2>
          <p></p>
        </div>

        <div class="row content">
          <div class="col-md-5" data-aos="fade-right" data-aos-delay="100">
            <img src="https://firebasestorage.googleapis.com/v0/b/indigo-listener-256706.appspot.com/o/features-1.png?alt=media&token=35fd2f27-d82d-4149-bc45-6636ee5d04c1" class="img-fluid" alt="">
          </div>
          <div class="col-md-7 pt-4" data-aos="fade-left" data-aos-delay="100">
            <h3>Expertise of Group Doctors</h3>
            <p class="fst-italic">
              With highly qualified and experience group of Doctors HealthVibe Hospitals has crossed milestones. Our expertise are well experienced in handling rare and critical cases.
            </p>
            <ul>
              <li><i class="bi bi-check"></i> Anesthesiologists – are the perioperative physicians, providing anesthetic care to patient throughout his/her surgical experience by managing the anesthic needs of a patient. </li>
              <li><i class="bi bi-check"></i> Dentist – are the specialized in treating the dental problems and gives an advice on taking care of gums and teeth and instructions on diet that can affect the oral health. </li>
              <li><i class="bi bi-check"></i> Dermatologist – is a medical specialist, diagnosing and treating skin disorders and disease and cosmetic problems of the skin..</li>
            </ul>
          </div>
        </div>

        <div class="row content">
          <div class="col-md-5 order-1 order-md-2" data-aos="fade-left">
            <img src="https://firebasestorage.googleapis.com/v0/b/indigo-listener-256706.appspot.com/o/features-2.png?alt=media&token=838e079a-6f68-4702-bdfd-c6756779550d" class="img-fluid" alt="">
          </div>
          <div class="col-md-7 pt-5 order-2 order-md-1" data-aos="fade-right">
            <h3>Right Treatment</h3>
            <p class="fst-italic">
              Right treatment begins with an accurate diagnosis. A team of specialists will listen to your needs and evaluate your condition from every angle in order to make the best plan.
            </p>
            <p>
             Treatment is medical attention given to a sick or injured person or animal. Many patients are not getting the medical treatment they need. ...a veterinary surgeon who specialises in the treatment of cage birds. Your treatment of someone is the way you behave towards them or deal with them. We don't want any special treatment.
            </p>
          </div>
        </div>

        <div class="row content">
          <div class="col-md-5" data-aos="fade-right">
            <img src="https://firebasestorage.googleapis.com/v0/b/indigo-listener-256706.appspot.com/o/features-3.png?alt=media&token=03c47784-9005-4962-8fe1-c9b38f194ac4" class="img-fluid" alt="">
          </div>
          <div class="col-md-7 pt-5" data-aos="fade-left">
            <h3>24/7 Active Health Care	</h3>
            <p>Every year millions of patient visits HealthVibe Hospitals. Our health care providers are unstoppable and are active for 24/7. The team take proper care of all the patients.</p><ul>
              <li><i class="bi bi-check"></i> We have a national infrastructure and local teams to support you where you need us..</li>
              <li><i class="bi bi-check"></i> We operate 24 hours a day, seven days a week, and you can always reach us 365 days a year..</li>
              <li><i class="bi bi-check"></i> Our mobile workforce utilises a purpose-built technology platform that operates in “real-time”, connecting our Nurses, Doctors and Patients.</li>
            </ul>
          </div>
        </div>

        
    </section><!-- End Features Section -->

<br>
	<!-- ======= Services Section ======= -->
    <section id="services" class="services">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>Check our <span>Services</span></h2>
          <p>major services provided by the hospital</p>
        </div>

        <div class="row">
          <div class="col-lg-4 col-md-6 d-flex align-items-stretch" data-aos="zoom-in" data-aos-delay="100">
            <div class="icon-box">
              <div class="icon"><i class="bx bxl-dribbble"></i></div>
              <h4><a href="">Emergency Services</a></h4>
              <p>Emergencies typically occur in cases like road accidents, cardiac problems, convulsions and so on. Trained technicians or paramedics provide first aid to the patient i.e. pre-hospital care and shift the patient to an appropriate facility. </p>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4 mt-md-0" data-aos="zoom-in" data-aos-delay="200">
            <div class="icon-box">
              <div class="icon"><i class="bx bx-file"></i></div>
              <h4><a href="">Out-patient Services</a></h4>
              <p>Out Patient services. Patients or caregivers to contact the reception counter for registrations and appointments. The receptionist will appraise the patient on the doctor’s availability and their timings. </p>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4 mt-lg-0" data-aos="zoom-in" data-aos-delay="300">
            <div class="icon-box">
              <div class="icon"><i class="bx bx-tachometer"></i></div>
              <h4><a href="">In-patient Services(ward)</a></h4>
              <p>We actually service the patients while they are in India for the surgery / treatment. Our team of Clinical Coordinators and Patient Care Managers meet the patient daily, coordinate clinically a</p>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4" data-aos="zoom-in" data-aos-delay="100">
            <div class="icon-box">
              <div class="icon"><i class="bx bx-world"></i></div>
              <h4><a href="">Intensive Care Unit</a></h4>
              <p>An intensive care unit (ICU), also known as an intensive therapy unit or intensive treatment unit (ITU) or critical care unit (CCU), is a special department of a hospital or health care facility that provides intensive care medicine. </p>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4" data-aos="zoom-in" data-aos-delay="200">
            <div class="icon-box">
              <div class="icon"><i class="bx bx-slideshow"></i></div>
              <h4><a href="">Operation theatre (OT)</a></h4>
              <p>An operating theater  is a facility within a hospital where surgical operations are carried out in aseptic environment.it is a tiered theater or amphitheater in which students and other spectators could watch surgeons perform surgery. </p>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4" data-aos="zoom-in" data-aos-delay="300">
            <div class="icon-box">
              <div class="icon"><i class="bx bx-arch"></i></div>
              <h4><a href="">Medical Services</a></h4>
              <p>Medical services means medical and health care services provided to a Person, including, but not limited to, medical and health care services provided to a Person </p>
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Services Section -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="services">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>Services</h2>
          <p>Emergency Care. Most hospitals provide emergency care for traumas and other serious conditions. ...</p>
        </div>

        <div class="row">
          <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0" data-aos="fade-up" data-aos-delay="100">
            <div class="icon-box">
              <div class="icon"><i class="bx bxl-dribbble"></i></div>
              <h4 class="title"><a href="">Kidney Transplantation</a></h4>
              <p class="description">with an increase in End-stage kidney disease cases in recent years,Kidney Transplantations is a blessings for patients with cronic renal disease.</p>
            </div>
          </div>

          <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0" data-aos="fade-up" data-aos-delay="200">
            <div class="icon-box">
              <div class="icon"><i class="bx bx-file"></i></div>
              <h4 class="title"><a href="">Physiotherapy</a></h4>
              <p class="description">Helps restore well being to people following injury,pain or disability.The Orthopedics department is ably supported by physiotherapy team</p>
            </div>
          </div>

          <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0" data-aos="fade-up" data-aos-delay="300">
            <div class="icon-box">
              <div class="icon"><i class="bx bx-tachometer"></i></div>
              <h4 class="title"><a href="">Internal Medicine</a></h4>
              <p class="description">Deals with a wide range of conditions,preventions,diagnosis,treatment of all possible internal diseases.</p>
            </div>
          </div>

          <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0" data-aos="fade-up" data-aos-delay="400">
            <div class="icon-box">
              <div class="icon"><i class="bx bx-layer"></i></div>
              <h4 class="title"><a href="">Critical care</a></h4>
              <p class="description">Multidisciplinary team of expert team with cutting edge technology,assure that any critically ill patient is ensured chances of survival</p>
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Services Section -->

    

    <!-- ======= Frequently Asked Questions Section ======= -->
    <section id="faq" class="faq">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>Frequently Asked Questions</h2>
        </div>

        <ul class="faq-list">

          <li>
            <div data-bs-toggle="collapse" class="collapsed question" href="#faq1">What can patients expect from Treatment?<i class="bi bi-chevron-down icon-show"></i><i class="bi bi-chevron-up icon-close"></i></div>
            <div id="faq1" class="collapse" data-bs-parent=".faq-list">
              <p>
		
               </p>
            </div>
          </li>

          <li>
            <div data-bs-toggle="collapse" href="#faq2" class="collapsed question">How do i contact if I have questions?<i class="bi bi-chevron-down icon-show"></i><i class="bi bi-chevron-up icon-close"></i></div>
            <div id="faq2" class="collapse" data-bs-parent=".faq-list">
              <p>
		
                </p>
            </div>
          </li>

          <li>
            <div data-bs-toggle="collapse" href="#faq3" class="collapsed question">
		For How long will i be kept in the ICU after my heart Surgery?  <i class="bi bi-chevron-down icon-show"></i><i class="bi bi-chevron-up icon-close"></i></div>
            <div id="faq3" class="collapse" data-bs-parent=".faq-list">
              <p>
                </p>
            </div>
          </li>

          <li>
            <div data-bs-toggle="collapse" href="#faq4" class="collapsed question">Can epilepsy be treated Surgically? <i class="bi bi-chevron-down icon-show"></i><i class="bi bi-chevron-up icon-close"></i></div>
            <div id="faq4" class="collapse" data-bs-parent=".faq-list">
              <p>
		
               </p>
            </div>
          </li>

          <li>
            <div data-bs-toggle="collapse" href="#faq5" class="collapsed question">How can I manage the side-effects related to chemotherapy for brain-tumour? <i class="bi bi-chevron-down icon-show"></i><i class="bi bi-chevron-up icon-close"></i></div>
            <div id="faq5" class="collapse" data-bs-parent=".faq-list">
              <p>
			
               </p>
            </div>
          </li>

          <li>
            <div data-bs-toggle="collapse" href="#faq6" class="collapsed question">What is the most common type of cancer in women?<i class="bi bi-chevron-down icon-show"></i><i class="bi bi-chevron-up icon-close"></i></div>
            <div id="faq6" class="collapse" data-bs-parent=".faq-list">
              <p>

               </p>
            </div>
          </li>

        </ul>

      </div>
    </section><!-- End Frequently Asked Questions Section -->

	<!-- ======= Counts Section ======= -->
    <section id="counts" class="counts">
      <div class="container" data-aos="fade-up">

        <div class="row">

          <div class="col-lg-3 col-md-6">
            <div class="count-box">
              <i class="bi bi-emoji-smile"></i>
              <span data-purecounter-start="0" data-purecounter-end="232" data-purecounter-duration="1" class="purecounter"></span>
              <p>Happy Clients</p>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 mt-5 mt-md-0">
            <div class="count-box">
              <i class="bi bi-journal-richtext"></i>
              <span data-purecounter-start="0" data-purecounter-end="521" data-purecounter-duration="1" class="purecounter"></span>
              <p>Projects</p>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 mt-5 mt-lg-0">
            <div class="count-box">
              <i class="bi bi-headset"></i>
              <span data-purecounter-start="0" data-purecounter-end="1463" data-purecounter-duration="1" class="purecounter"></span>
              <p>Hours Of Support</p>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 mt-5 mt-lg-0">
            <div class="count-box">
              <i class="bi bi-people"></i>
              <span data-purecounter-start="0" data-purecounter-end="15" data-purecounter-duration="1" class="purecounter"></span>
              <p>Hard Workers</p>
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Counts Section -->

  

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact section-bg">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>Contact Us</h2>
          <p>HealthVibe has been a pioneer in bringing worldclass healthcare to the doorsteps of every Indian.</p>
        </div>

        <div class="row">

          <div class="col-lg-6">

            <div class="row">
              <div class="col-md-12">
                <div class="info-box">
                  <i class="bx bx-map"></i>
                  <h3>Our Address</h3>
                  <p>A108 Adam Street, New York, NY 535022</p>
                </div>
              </div>
              <div class="col-md-6">
                <div class="info-box mt-4">
                  <i class="bx bx-envelope"></i>
                  <h3>Email Us</h3>
                  <p>info@example.com<br>contact@example.com</p>
                </div>
              </div>
              <div class="col-md-6">
                <div class="info-box mt-4">
                  <i class="bx bx-phone-call"></i>
                  <h3>Call Us</h3>
                  <p>+1 5589 55488 55<br>+1 6678 254445 41</p>
                </div>
              </div>
            </div>

          </div>

          <div class="col-lg-6 mt-4 mt-md-0">
            <form action="forms/contact.php" method="post" role="form" class="php-email-form">
              <div class="row">
                <div class="col-md-6 form-group">
                  <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" required>
                </div>
                <div class="col-md-6 form-group mt-3 mt-md-0">
                  <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required>
                </div>
              </div>
              <div class="form-group mt-3">
                <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" required>
              </div>
              <div class="form-group mt-3">
                <textarea class="form-control" name="message" rows="5" placeholder="Message" required></textarea>
              </div>
              <div class="my-3">
                <div class="loading">Loading</div>
                <div class="error-message"></div>
                <div class="sent-message">Your message has been sent. Thank you!</div>
              </div>
              <div class="text-center"><button type="submit">Send Message</button></div>
            </form>
          </div>

        </div>

      </div>
    </section><!-- End Contact Section -->

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer">

    <div class="footer-top">
      <div class="container">
        <div class="row">

          <div class="col-lg-3 col-md-6 footer-contact">
            <h3>HealthVibe</h3>
            <p>
              A108 Adam Street <br>
              New York, NY 535022<br>
              United States <br><br>
              <strong>Phone:</strong> +1 5589 55488 55<br>
              <strong>Email:</strong> info@example.com<br>
            </p>
          </div>

          <div class="col-lg-2 col-md-6 footer-links">
            <h4>Useful Links</h4>
            <ul>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Home</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">About us</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Services</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Terms of service</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Privacy policy</a></li>
            </ul>
          </div>

          <div class="col-lg-3 col-md-6 footer-links">
            <h4>Our Services</h4>
            <ul>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Kidney Transplantations</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Physiotherapy</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Internal Medicine</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="#">Critical Care</a></li>
             
            </ul>
          </div>

          <div class="col-lg-4 col-md-6 footer-newsletter">
            <h4>Join Our Newsletter</h4>
            <p>Laboratory for Drug Discovery in Neuroscience. Contact; Interdisciplinary Neuroscience Pilot Award Program; Genomics and Bioinformatics Hub; News. Announcements; Events. Events Calendar; Support Us;</p>
            <form action="" method="post">
              <input type="email" name="email"><input type="submit" value="Subscribe">
            </form>
          </div>

        </div>
      </div>
    </div>

    <div class="container d-md-flex py-4">

      <div class="me-md-auto text-center text-md-start">
        <div class="copyright">
          &copy; Copyright <strong><span>HealthVibe</span></strong>. All Rights Reserved
        </div>
        <div class="credits">
          <!-- All the links in the footer should remain intact. -->
          <!-- You can delete the links only if you purchased the pro version. -->
          <!-- Licensing information: https://bootstrapmade.com/license/ -->
          <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/Hospital Management System-free-simple-landing-page-template/ -->
          Designed by <a href="https://bootstrapmade.com/">Hospital Management System</a>
        </div>
      </div>
      <div class="social-links text-center text-md-right pt-3 pt-md-0">
        <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
        <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
        <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
        <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
        <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
      </div>
    </div>
  </footer><!-- End Footer -->

  <div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>