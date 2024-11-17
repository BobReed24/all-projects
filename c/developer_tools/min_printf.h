

#ifndef MIN_PRINTF_H
#define MIN_PRINTF_H

#include <stdlib.h> 
#ifdef _WIN32
	#include <io.h>		
#else
	#include <unistd.h> 
#endif
#include <stdarg.h> 

#define INT_MAX_LENGTH 10       
#define PRECISION_FOR_FLOAT 8   


typedef struct buffer {
	char buffr_char; 
	int buf_size; 
} Buffer;


int power_of_ten(int a)
{
	int n = 1; 
	for (int i = 1; i <= a; ++i)
		n *= 10 ;
	return n;
}


int is_number(char *c)
{
	return (*c >= '0' && *c <= '9') ? 1 : 0;
}


char get_ch(char *p, Buffer *buffer)
{
	if (buffer->buf_size) {
		buffer->buf_size = 0; 
		return buffer->buffr_char; 
	}
	return *p++;
}


void unget_ch(char *c, Buffer *buffer)
{
	buffer->buffr_char = *c;	
	buffer->buf_size = 1; 
}



int get_number_of_digits(int n)
{
	int digits = 0; 
	while (n > 0) {
		++digits; 
		n /= 10; 
	}
	return digits;
}


void put_char(char s)
{
	
	char *buf = (char *) malloc(sizeof(char) + 1); 
	*buf = s;
	*(buf + 1) = '\0';
	write(1, buf, 1);
	free(buf);
}


void reverse_str(char *p)
{
	char *l = p; 
	char *h = p; 
	char temp; 

	while (*h != '\0') 
		++h;
	--h; 

	
	while (l < h) {
		temp = *l;
		*l = *h;
		*h = temp;
		++l; 
		--h; 
	}
}


void print_int_value(int n, int width, int precision)
{
	char *p = (char *) malloc(INT_MAX_LENGTH * sizeof(char) + 1); 
	char *s = p; 
	int size = 0; 

	while (n > 0) {
		*s++ = n % 10 + '0'; 
		++size; 
		n /= 10; 
	}
	*s = '\0';

	s = p; 

	reverse_str(p);

	
	if (width > 0 && size < width)
		for (int i = 0; i < (width - precision); ++i) 
			put_char(' ');

	if (precision > 0 && precision > size)
		for (int i = 0; i < (precision - size); ++i)
			put_char('0');

	
	while (*s != '\0')
		put_char(*s++);

	free(p);
}


void print_double_value(double dval, int width, int precision)
{
	int ndigits = get_number_of_digits((int) dval); 
	int reqd_blanks = width - (precision + 1) - ndigits; 
	
	print_int_value((int) dval, reqd_blanks, 0); 

	put_char('.'); 

	
	dval = dval - (int) dval;

	dval *= power_of_ten(precision); 
	
	print_int_value((int) dval, 0, precision); 
}


void print_string(char *p, int width, int precision)
{
	int size = 0; 
	char *s = p; 

	
	while (*s != '\0') { 
		++size;
		++s;
	}

	s = p; 

	
	if (precision != 0 && precision < size)
		size = precision;

	
	for (int i = 0; i < (width - size); ++i)
		put_char(' ');

	
	for (int i = 0; i < size; ++i)
		put_char(*s++);

}


char *get_width_and_precision(char *p, Buffer *buffer, int *width, int *precision)
{
	
	if (*p == '%')
		++p;
	
	
	while (*p != '.' && is_number(p)) 
		*width = *width * 10 + (*p++ - '0');

	
	if (*p == '.' ) { 
		while (is_number(++p))
			*precision = *precision * 10 + (*p - '0'); 
		unget_ch(p, buffer); 
	}
	return p;
}


void min_printf(char *fmt, ...)
{
	va_list ap; 
	char *p, *sval; 
	char cval; 
	int ival; 
	double dval; 
	va_start(ap, fmt); 

	
	Buffer *buffer = (Buffer *) malloc(sizeof(Buffer));
	buffer->buf_size = 0; 

	for (p = fmt; *p != '\0'; ++p) {
		
		
		if (*p != '%') {
			put_char(*p);
			continue;
		}
		
		int width = 0; 
		int precision = 0; 

		
		p = get_width_and_precision(p, buffer, &width, &precision); 
		
		
		switch (get_ch(p, buffer)) {
			case 'd': 
				ival = va_arg(ap, int);
				print_int_value(ival, width, precision);
				break;
			case 'c': 
				cval = va_arg(ap, int);
				put_char(cval);
				break;
			case 'f': 
				dval = va_arg(ap, double);

				
				if (precision == 0)
					precision = PRECISION_FOR_FLOAT;
				print_double_value(dval, width, precision);
				break;
			case 's': 
				sval = va_arg(ap, char *);
				print_string(sval, width, precision);
				break;
			default:
				put_char(*p);
				break;
		}
	}
	va_end(ap);
}

#endif 
