'use strict';

import { BlogPost } from "../../day-03/02BlogPost/02BlogPost";

// Reuse your BlogPost class
// Create a Blog class which can
// store a list of BlogPosts
// add BlogPosts to the list
// delete(int) one item at given index
// update(int, BlogPost) one item at the given index and update it with another BlogPost

class Blog {
  blogs: BlogPost[] = [];

  // Add a new BlogPost object to the blogs property
  addPost(adds: BlogPost): void {
    this.blogs.push(adds);
  }

  // If the given index exists in the blogs array property, it will delete it
  deletePost(index: number): void {
    if (this.blogs[index]) {
      this.blogs.splice(index, 1);
    } else {
      console.log('Sorry, the index, you provided (' + index + ') does not exist');
    }
  }

  updatePost(index: number, bp: BlogPost) {
    if (this.blogs[index]) {
      this.blogs[index] = bp;
    } else {
      console.log('Sorry, the index, you provided (' + index + ') does not exist');
    }
  }
}

let blog: Blog = new Blog();

// Test the methods
console.log(blog);

blog.addPost(new BlogPost('author1', 'title1', 'text1', 'date1'));
blog.addPost(new BlogPost('author2', 'title2', 'text2', 'date2'));
blog.addPost(new BlogPost('author3', 'title3', 'text3', 'date3'));
console.log(blog);

blog.deletePost(1);
console.log(blog);

blog.deletePost(2); // this should be an error
console.log(blog);

blog.updatePost(1, new BlogPost('author4', 'title4', 'text4', 'date4'));
console.log(blog);

blog.updatePost(3, new BlogPost('author5', 'title5', 'text5', 'date5')); // this should be an error
console.log(blog);