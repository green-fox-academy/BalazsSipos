﻿// <auto-generated />
using System;
using MediProject2;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;

namespace MediProject2.Migrations
{
    [DbContext(typeof(ApplicationContext))]
    partial class ApplicationContextModelSnapshot : ModelSnapshot
    {
        protected override void BuildModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "2.1.11-servicing-32099")
                .HasAnnotation("Relational:MaxIdentifierLength", 64);

            modelBuilder.Entity("MediProject2.Models.City", b =>
                {
                    b.Property<int>("CityId")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("CityName");

                    b.Property<int?>("CountryId");

                    b.HasKey("CityId");

                    b.HasIndex("CountryId");

                    b.ToTable("Cities");
                });

            modelBuilder.Entity("MediProject2.Models.Country", b =>
                {
                    b.Property<int>("CountryId")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("CountryName");

                    b.HasKey("CountryId");

                    b.ToTable("Countries");
                });

            modelBuilder.Entity("MediProject2.Models.User", b =>
                {
                    b.Property<int>("UserId")
                        .ValueGeneratedOnAdd();

                    b.Property<int?>("CountryId");

                    b.Property<string>("UserName");

                    b.Property<int?>("UserProfileId");

                    b.HasKey("UserId");

                    b.HasIndex("CountryId");

                    b.HasIndex("UserProfileId");

                    b.ToTable("Users");
                });

            modelBuilder.Entity("MediProject2.Models.UserProfile", b =>
                {
                    b.Property<int>("UserProfileId")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("ProfilePicture");

                    b.HasKey("UserProfileId");

                    b.ToTable("UserProfiles");
                });

            modelBuilder.Entity("MediProject2.Models.City", b =>
                {
                    b.HasOne("MediProject2.Models.Country", "Country")
                        .WithMany("Cities")
                        .HasForeignKey("CountryId");
                });

            modelBuilder.Entity("MediProject2.Models.User", b =>
                {
                    b.HasOne("MediProject2.Models.Country", "Country")
                        .WithMany()
                        .HasForeignKey("CountryId");

                    b.HasOne("MediProject2.Models.UserProfile", "Userprofile")
                        .WithMany()
                        .HasForeignKey("UserProfileId");
                });
#pragma warning restore 612, 618
        }
    }
}
